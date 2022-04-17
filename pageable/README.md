# Pageable

## What's this

ページングやソートのクエリパラメータをよしなに受け取ってくれるPageableとSortのサンプルです。

## Usage

appを起動して以下のリクエストを送って動作確認する。

```bash
# ページングのクエリパラメータ
# 何も指定しないとdefault値が使われる
curl 'http://localhost:8080/v1/pageable'
Page request [number: 0, size 10, sort: updated_date: DESC]

# 指定するとその値が使われる
curl 'http://localhost:8080/v1/pageable?number=10&size=20&sort=id'
Page request [number: 0, size 20, sort: id: ASC]

# 複数カラムソートは以下のように指定する
curl 'http://localhost:8080/v1/pageable?number=10&size=20&sort=id,desc&sort=name'
Page request [number: 0, size 20, sort: id: DESC,name: ASC]
```

```bash
# ソートのクエリパラメータ
# 使い方はpageableのsortと同じ
# 何も指定しないとdefault値が使われる
curl 'http://localhost:8080/v1/sort'
updated_date: DESC

# 指定するとその値が使われる
curl 'http://localhost:8080/v1/sort?sort=id'
id: ASC

# 複数カラムソートは以下のように指定する
curl 'http://localhost:8080/v1/sort?sort=id,desc&sort=name'
id: DESC,name: ASC
```