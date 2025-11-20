# Stage 1: Build Angular
FROM node:20-alpine AS builder

WORKDIR /app

COPY package*.json ./
RUN npm ci

COPY . .
RUN npm run build -- --configuration=production

# Stage 2: Serve with Nginx
FROM nginx:stable-alpine

# Xóa index mặc định của Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copy build output đúng folder browser
COPY --from=builder /app/dist/my_task_management/browser /usr/share/nginx/html

# Copy Nginx config
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]