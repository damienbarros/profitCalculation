FROM ubuntu:latest
LABEL authors="damien"

ENTRYPOINT ["top", "-b"]