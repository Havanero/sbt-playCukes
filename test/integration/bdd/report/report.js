$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hello-world.feature");
formatter.feature({
  "line": 1,
  "name": "Say Hello",
  "description": "",
  "id": "say-hello",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Check Hello World",
  "description": "",
  "id": "say-hello;check-hello-world",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "that I am on the main site",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the index page is display",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should see \"hello world\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HelloWorld.scala:12"
});
formatter.result({
  "duration": 190315101,
  "status": "passed"
});
formatter.match({
  "location": "HelloWorld.scala:16"
});
formatter.result({
  "duration": 111012,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hello world",
      "offset": 14
    }
  ],
  "location": "HelloWorld.scala:19"
});
formatter.result({
  "duration": 2933344,
  "status": "passed"
});
});