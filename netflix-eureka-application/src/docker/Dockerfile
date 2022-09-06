FROM openjdk
COPY app.jar /opt
COPY jib/entrypoint.sh /opt/entrypoint.sh
RUN chmod a+x /opt/entrypoint.sh
ENTRYPOINT ["/opt/entrypoint.sh"]