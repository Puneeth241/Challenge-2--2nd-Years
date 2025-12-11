Optimization Summary

Replaced manual BufferedReader file handling with Files.readAllLines() and Files.readString() to make file reading faster and cleaner.
Simplified the rotation logic using a single conditional expression instead of multiple if statements.
Used middleRow.chars().sum() to calculate the ASCII sum more efficiently.
Pre-allocated the list size to avoid unnecessary resizing and improve performance.
Reduced overall code length and improved readability while keeping the same functionality.