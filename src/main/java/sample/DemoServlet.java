package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(DemoServlet.class.getName());
       
    static {
        try {
            // Ensure the logs directory exists
            File logsDir = new File("logs");
            if (!logsDir.exists()) {
                logsDir.mkdirs();
            }

            // Remove default console handler if it exists
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }

            // Add custom console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new CustomFormatter());
            rootLogger.addHandler(consoleHandler);

            // Add file handler
            FileHandler fileHandler = new FileHandler("logs/myapp.log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new CustomFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler.", e);
        }
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
        logger.info("DemoServlet instance created");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Processing GET request");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.println("<h1>Hello!</h1></br>");
        pw.println("<h2>My name is Daniella Niyonsenga.</h2>");
        pw.println("<h2>My ID is 25235!</h2>");
        logger.info("GET request processed successfully");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Processing POST request");
        doGet(request, response);
        logger.info("POST request processed successfully");
    }

    /**
     * Custom Formatter for log messages
     */
    public static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return String.format("[%1$tF %1$tT] [%2$s] [%3$s] %4$s %n",
                    record.getMillis(),
                    record.getSourceClassName(),
                    record.getLevel().getName(),
                    record.getMessage());
        }
    }
}
