# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y wget unzip git maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Set the working directory
WORKDIR /workspace

# Copy the local project to the working directory
COPY . .

# Open port 8080 for web access
EXPOSE 8080

# Run the application
CMD ["mvn", "spring-boot:run"]