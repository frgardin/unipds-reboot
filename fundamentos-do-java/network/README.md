# Java Network — Fundamentos

Educational project exploring Java networking APIs, from legacy `URLConnection` to the modern `HttpClient`.

---

## Client Training Classes

All classes live in `dev.unipds.network.client` and consume the [ViaCEP](https://viacep.com.br) public API to fetch Brazilian postal code data.

### Training1 — `URLConnection` (verbose)

Uses the classic `URL` + `URLConnection` + `InputStream` stack. Manually opens a connection and reads the response line by line with a `Scanner`. No resource cleanup.

```java
URL url = new URL("https://viacep.com.br/ws/01001000/json/");
URLConnection urlConnection = url.openConnection();
InputStream inputStream = urlConnection.getInputStream();
Scanner sc = new Scanner(inputStream);
while (sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}
```

**Key classes:** `java.net.URL`, `java.net.URLConnection`, `java.io.InputStream`, `java.util.Scanner`

---

### Training2 — `URL.openStream()` (shorthand)

Simplifies `Training1` by replacing `url.openConnection().getInputStream()` with the convenience method `url.openStream()`. Adds explicit `sc.close()` for resource cleanup.

```java
InputStream inputStream = url.openStream();
Scanner sc = new Scanner(inputStream);
// ...
sc.close();
```

**Key classes:** `java.net.URL`, `java.io.InputStream`, `java.util.Scanner`

---

### Training3 — try-with-resources

Refactors `Training2` to use a `try-with-resources` block. `Scanner` implements `Closeable`, so it is automatically closed even if an exception is thrown.

```java
try (Scanner sc = new Scanner(inputStream)) {
    while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
    }
}
```

**Key classes:** `java.net.URL`, `java.io.InputStream`, `java.util.Scanner`

---

### Training4 — `HttpClient` (modern API, Java 11+)

Replaces the legacy URL stack with the `java.net.http` package introduced in Java 11. Uses `URI`, `HttpClient`, `HttpRequest`, and `HttpResponse`. Exposes the HTTP status code and reads the body as a `String`. `HttpClient` itself is also used in a try-with-resources block (implements `Closeable` since Java 21).

```java
URI uri = URI.create("https://viacep.com.br/ws/01001000/json/");
try (HttpClient httpClient = HttpClient.newHttpClient()) {
    HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

    System.out.println("StatusCode: " + httpResponse.statusCode());
    System.out.println("Body: " + httpResponse.body());
}
```

**Key classes:** `java.net.URI`, `java.net.http.HttpClient`, `java.net.http.HttpRequest`, `java.net.http.HttpResponse`

---

## jwebserver — Simple Web Server (JDK 18+)

`jwebserver` is a minimal HTTP file server shipped with the JDK since Java 18 (JEP 408). It serves static files from a directory over HTTP — useful for local testing, serving JSON fixtures, or pointing an `HttpClient` at a local endpoint during development.

### Starting the server

```bash
# Serve the current directory on the default port (8000)
jwebserver

# Serve a specific directory
jwebserver -d /path/to/directory

# Bind to a specific address and port
jwebserver -b 0.0.0.0 -p 9000

# Combine options
jwebserver -b 127.0.0.1 -p 8080 -d ./src/main/resources
```

### Key options

| Option | Description                          | Default     |
|--------|--------------------------------------|-------------|
| `-b`   | Bind address                         | `127.0.0.1` |
| `-p`   | Port                                 | `8000`      |
| `-d`   | Directory to serve                   | `.` (cwd)   |
| `-o`   | Output format: `none`, `info`, `verbose` | `info`  |

### Example — serve a JSON file and consume it with `HttpClient`

1. Place a JSON file in a directory:

```bash
echo '{"cep":"01001-000"}' > /tmp/mock/data.json
jwebserver -d /tmp/mock -p 8080
```

2. Fetch it from Java:

```java
URI uri = URI.create("http://localhost:8080/data.json");
try (HttpClient client = HttpClient.newHttpClient()) {
    HttpRequest request = HttpRequest.newBuilder(uri).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
}
```

### Limitations

- Serves **static files only** — no dynamic content, no POST handling.
- **Not** intended for production use.
- Only supports HTTP/1.1.
