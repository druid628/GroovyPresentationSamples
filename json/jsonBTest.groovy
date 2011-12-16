import groovy.json.*;

def builder = new JsonBuilder()
def root = builder.people {
    person {
      firstName 'Micah'
      lastName 'Breedlove'
      address (
        city:  "Hermitage",
        state:  "TN",
        zip: "37076"
      )
      married true
    }
}

System.out.println(builder.toString());

