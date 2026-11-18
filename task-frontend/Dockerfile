
# Build stage
FROM node:22-bookworm AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci --no-audit --no-fund

COPY . .

RUN npm run build -- --configuration production

# Production stage
FROM nginx:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/dist/*/browser /usr/share/nginx/html

EXPOSE 80