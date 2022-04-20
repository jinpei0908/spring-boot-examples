# validation example

## What's this

spring bootのvalidationのサンプルをまとめたリポジトリです。

## Usage

appを起動後、以下のリクエストを投げるとエラーが返ってきます。

### field validationの確認

```bash
curl -s 'http://localhost:8080/v1/modelattribute-and-bindingresult?id=0&name=&age=-1' | jq
```
```
{
  "errorMessage": "nameは1 から 2147483647 の間のサイズにしてください。ageは0 以上の値にしてください。idは0 より大きな値にしてください。"
}
```

### field validationとfield同士の関係のvalidation

```bash
curl -s 'http://localhost:8080/v1/modelattribute-and-custom-validator?id=0' | jq
```
```
{
  "errorMessage": "idは0 より大きな値にしてください。nameかageのどちらかは指定してください。"
}
```

### PathVariableのvalidation
```bash
curl -s 'http://localhost:8080/v1/path-variable/0/hello*' | jq
```
```
{
  "errorMessage": "getUser.id: 1 から 1000000000 の間にしてください, getUser.name: 正規表現 \"[A-z]+\" にマッチさせてください"
}
```
