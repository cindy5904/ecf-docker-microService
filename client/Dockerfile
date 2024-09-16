FROM node:14 AS builder

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build

FROM node:14

WORKDIR /app

COPY --from=builder /app/build /app/build
COPY --from=builder /app/server.js /app/
COPY --from=builder /app/package.json /app/
COPY --from=builder /app/node_modules /app/node_modules

EXPOSE 3000

CMD ["npm", "start"]
