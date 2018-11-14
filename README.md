Cytoscape KAR Sample
--------------------

Build:

`mvn clean install`

Configure Cytoscape

* Edit `features.xml`
  * uncomment feature kar line

* Edit `org.apache.karaf.kar.cfg`
  * uncomment karStorage line

* Edit `org.ops4j.pax.url.mvn.cfg`
  * Find the `org.ops4j.pax.url.mvn.defaultRepositories` property and make it look like below:
  * `org.ops4j.pax.url.mvn.defaultRepositories=file:${karaf.home}/${karaf.default.repository}@id=system.repository@snapshots,file:${karaf.data}/kar@id=kar.repository@multi@snapshots`

Start Cytoscape from the command line

`./cytoscape.sh`

Then in the Karaf console run the following commands:

* `system:property http.proxyPort 8080`
* `kar:install file:/path/to/kartest/org.baderlab.kartest._feature/target/org.baderlab.kartest._feature-0.0.1-SNAPSHOT.kar`

Note some exceptions may show in the console.

In Cytoscape

* Open a Network
* Run the UI code by going to the menu at `Apps > KarTest App`.
* Run the Command by
  * Go to `View > Show Automation Panel`. Then run the command `kartest analyze`.
  * Go to `Help > Automation > CyRest Command API`. In the browser that opens expand `kartest`, expand `POST /v1/commands/kartest/analyze`, then click the `try it out` button.
