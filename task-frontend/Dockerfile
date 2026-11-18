
# Build stage
FROM node:22-bookworm AS build

# Use a consistent npm version
RUN npm install -g npm@10.8.2

WORKDIR /app

# Copy dependency files
COPY package*.json ./

# Install dependencies
RUN npm ci --no-audit --no-fund

# Copy application source
COPY . .

# Build Angular application
RUN npm run build -- --configuration production

# Production stage
FROM nginx:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/dist/*/browser /usr/share/nginx/html

EXPOSE 80