# Build stage
FROM node:22-bookworm-slim AS build

WORKDIR /app

# Copy dependency files
COPY package*.json ./

# Install dependencies
RUN npm ci --no-audit --no-fund --verbose

# Copy application
COPY . .

# Build Angular application
RUN npm run build

# Production stage
FROM nginx:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/dist/*/browser /usr/share/nginx/html

EXPOSE 80