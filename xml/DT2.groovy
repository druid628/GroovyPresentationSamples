import groovy.xml.MarkupBuilder
def books = [
 "1":"The Gunslinger",
 "2":"The Drawing of the Three",
 "3":"Wastelands",
 "4":"Wizard and Glass",
 "5":"Wolves of the Calla",
 "6":"Song of Susannah",
 "7":"The Dark Tower"
]


import groovy.xml.MarkupBuilder
def xml = new MarkupBuilder()
xml.DarkTower() {
  books.each{ key, value ->
    book(sequence:key) { name(value) }
  }
}

/*
def builder = new groovy.xml.MarkupBuilder()
builder.'Dark-Tower' {
    'book1' 'The Gunslinger'
    'book2' 'The Drawing of the Three'
    'book3' 'Wastelands'
    'book4' 'Wizard and Glass'
    'book5' 'Wolves of the Calla'
    'book6' 'Songs of Susannah'
    'book7' 'The Dark Tower'
}*/
