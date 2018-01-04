## Setup

To get an interactive development environment run:

    lein figwheel

This will compile everything and launch a browser at http://localhost:3000

The repl will launch and your can easily test it with 

    (js/alert "Am I connected?")

You now have a complete dev environment setup.

## Ring server

A ring server is serving the application

If you ever want to just serve the application without running
figwheel you can just do:

    lein ring
	
## Deployment

You can easily create a standalone jar file which you can deploy to
Heroku or some other deployment container like so

    lein package
	
Please refer to the `project.clj` under `:aliases` to see how it works.

The resulting jar file can be executed with:

    java -jar target/example-0.1.0-SNAPSHOT-standalone.jar

You can also set a PORT environment variable:
   
    PORT=5555 java -jar target/example-0.1.0-SNAPSHOT-standalone.jar

## Notes 

Please take some time to look at the `project.clj` and the `user.clj`

## License

Copyright © 2018 AWESOME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
