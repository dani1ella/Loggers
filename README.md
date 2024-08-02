logging is the process of recording or storing information or messages that help in understanding the behavior and execution of a program.
Logging is important as it allows developers and system administrators to control the verbosity of log output. 
It helps in identifying and troubleshooting issues, monitoring application behavior, and managing log file sizes effectively.
Logging levels determine which entries will be recorded in a log and their level of granularity. 
Once set, any requests made by an application that meets its threshold will be added to it in real-time.

DEBUG is the default logging level and should be used for debugging purposes during development. 
It includes detailed, granular information to aid in diagnosing issues in an application and third-party libraries used.

INFO is another logging level which tracks messages regarding routine application operations, such as when services start or stop running,
resources being added, deleted, updated or modified in databases etc. Most system administrators monitor this log to make sure everything is functioning smoothly.

FATAL is the highest severity logging level and generally indicates messages that indicate something has broken in an application and require engineer intervention to continue 
functioning effectively. Therefore, you should use a log management service to alert you whenever these entries appear to prevent further data corruption and loss.
