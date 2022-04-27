# ModelAttribute

## What's this

`ModelAttribute`の挙動を調べた時のサンプルです。

## Usage

appを起動して以下のリクエストを送る。

```bash
# validationエラーにならない
curl 'http://localhost:8080/v1/bind-by-model-attribute?id=3&name=JohnDoe&favoriteMovies=Inception,DarkKnight&favoriteArtists=theBeatles,RedHotChiliPeppers&friendIds=1,100,50' | jq
```

カンマ区切りがリストとして解釈されている

```json
{
  "id": 3,
  "name": "JohnDoe",
  "favoriteMovies": [
    "Inception",
    "DarkKnight"
  ],
  "favoriteArtists": [
    "theBeatles",
    "RedHotChiliPeppers"
  ],
  "friendIds": [
    1,
    100,
    50
  ]
}
```

```bash
# validationエラーになる
curl 'http://localhost:8080/v1/bind-by-model-attribute?id=3&name=JohnDoe&favoriteMovies=Inception,DarkKnight&favoriteArtists=theBeatles,RedHotChiliPeppers0&friendIds=1,100,500' | jq
```

```json
{
  "timestamp": "2022-04-27T07:52:12.649+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/v1/bind-by-model-attribute"
}
```