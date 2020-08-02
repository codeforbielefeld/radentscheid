# bike-casualties

## Build Setup

```bash
# install dependencies
$ yarn install

# serve with hot reload at localhost:3000
$ yarn dev

# build for production and launch server
$ yarn build
$ yarn start

# generate static project
$ yarn generate
```

For detailed explanation on how things work, check out [Nuxt.js docs](https://nuxtjs.org).

## Build a local Docker image

```bash
$ docker build -t ruk:latest .
```

Run the docker image and expose the port 3000 to 127.0.0.1:

```bash
$ docker run -p 127.0.0.1:3000:3000/tcp ruk:latest
```

