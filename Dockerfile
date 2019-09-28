FROM centos:7

RUN yum install -y java-1.8.0-openjdk-headless \
    && yum clean all -y \
    && mkdir -p /opt/lib \
    && mkdir -p  /data/home/my-gps/config \
    && mkdir -p  /data/home/my-gps/lib

COPY target/my-gps-0.0.1-SNAPSHOT.jar /opt/lib

WORKDIR  /opt/lib

CMD ["java","-jar",\
            "-server",\
            "-Xmx200m",\
            "-Xms200m",\
            "-Xmn100m",\
            "-Dspring.config.location=/data/home/my-gps/config/application.properties",\
            "-Dlogging.config=/data/home/my-gps/config/logback.xml",\
            "/opt/lib/my-gps-0.0.1-SNAPSHOT.jar"]

