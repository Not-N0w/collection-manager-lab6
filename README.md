# Lab Work №6

Java client-server application (variant №9928) using TCP/NIO with serialization and Stream API.

## Description

This lab continues work from Lab 5, separating the application into two modules:
- **Server** — stores and manages the collection, handles commands, and saves data.
- **Client** — reads commands interactively, sends them to the server, and prints responses.

Features:
- Non-blocking NIO communication over TCP
- Object serialization for command exchange
- Stream API with lambda expressions for collection handling
- Logging with Logback
- Graceful handling of server unavailability

## Technologies

- Java NIO
- Gradle
- Docker (for containerization)
- Logback

## Project Structure

📁 `client/` — client-side logic  
📁 `server/` — server-side logic  
📁 `common/` — shared classes

## Full Report

📄 See [report.pdf](./лаб6.pdf) for full details.
