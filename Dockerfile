FROM groovy
WORKDIR /opt/groovy-spring
COPY . /opt/groovy-spring
EXPOSE 8080
CMD groovy /opt/groovy-spring/groovy-springboot.groovy
