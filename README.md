# SnipURL - URL Shortener Service

SnipURL is a URL shortener service built using Spring Boot. It allows users to shorten long URLs into concise and shareable links. This repository contains the source code for the SnipURL application.

## Features

- **URL Shortening:** Convert long URLs into short, easy-to-share links.
- **Redirection:** Redirect users from the short URL to the original long URL.

## Live Demo

Check out the live demo of SnipURL at [https://snipurl-demo.railway.app](https://snipurl-demo.railway.app).

## Deployment on Railway

1. **Create a Railway Account:**
   Sign up for a Railway account at [https://railway.app](https://railway.app/).

2. **Create a mySql instance:**
   Connect the Data layer to the application. 
   
3. **Connect Your GitHub Repository:**
   Connect your GitHub repository to Railway.
   
4. **Configure Your Project:**
   Change the environment variables

5. **Deploy Your Application:**
   Deploy your Spring Boot application on Railway.

## Development Setup

To run the SnipURL application locally for development or testing purposes, follow these steps:

```bash
# Clone the repository
git clone https://github.com/yourusername/snipurl.git

# Navigate to the project directory
cd snipurl

# Configure application.properties file with your database and other settings

# Run the application
./mvnw spring-boot:run
