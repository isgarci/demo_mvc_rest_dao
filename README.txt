
mvn -Declipse.workspace=<path-to-eclipse-workspace> eclipse:add-maven-repo

cd ${workingDirectory}/demo_stock_prices

cd demo_stock_prices_model
mvn clean package
mvn install
mvn eclipse:eclipse

cd ../demo_stock_prices_server
mvn clean package
mvn install
mvn eclipse:eclipse
mvn jetty:run

cd ../demo_stock_prices_client
mvn clean package
mvn install
mvn eclipse:eclipse


From eclipse, run the desktop application 



