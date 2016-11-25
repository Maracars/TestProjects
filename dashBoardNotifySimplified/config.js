module.exports = {
  db: {
    user: 'joanes', //env var: PGUSER
  database: 'joanes', //env var: PGDATABASE
  password: '1234', //env var: PGPASSWORD
  host: 'localhost', // Server hosting the postgres database
  port: 5432, //env var: PGPORT
  max: 10, // max number of clients in the pool
  idleTimeoutMillis: 30000 // how long a client is allowed to remain idle before being closed
  },
  redis: {
    url: "redis://some-redis-server:6379"
  }
};

