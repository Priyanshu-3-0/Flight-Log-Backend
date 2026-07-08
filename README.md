# Drone Flight Log Auto-Upload Backend

## Overview
Spring Boot backend that automatically detects completed drone flight logs, parses ArduPilot `.BIN` files using Python, stores metadata and GPS points in MySQL, copies logs to local storage (cloud simulation), exposes REST APIs, and handles failures gracefully.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Python (parser)
- Swagger 
- Maven

## Features
- Automatic folder watching (`mission_logs`)
- Automatic `.BIN` detection
- Background processing with `@Async`
- Python parser integration
- Flight & GPS persistence
- Local storage simulation
- Download API
- Status API (`PROCESSING`, `SUCCESS`, `FAILED`)
- Graceful failure handling

## Architecture
QGroundControl/SITL
 -> mission_logs
 -> FileWatcherService
 -> PythonService
 -> parser.py
 -> gps_data.json
 -> JsonReader
 -> MySQL
 -> LocalStorageService
 -> Download API

## APIs
| Method | Endpoint | Purpose |
|---|---|---|
| POST | /api/upload | Upload BIN manually |
| GET | /api/flights | List flights |
| GET | /api/flights/{id} | Flight details |
| GET | /api/flights/{id}/status | Processing status |
| GET | /api/flights/{id}/download | Download stored BIN |

## Failure Handling
If storage fails (invalid path, permissions, unavailable drive), the application:
- catches the exception
- records FAILED status
- stores failure reason
- keeps backend running

## Setup
1. Install Java 17, Maven, MySQL, Python.
2. Configure application.properties.
3. Run Spring Boot.
4. Place `.BIN` in mission_logs or upload via Swagger.
