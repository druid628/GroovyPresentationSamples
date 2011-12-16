import groovy.xml.MarkupBuilder

def xml = new MarkupBuilder()
xml.DarkTower() 
{
  book(sequence:1) 
  {
    name("The Gunslinger")
  }

  book(sequence:2) 
  {
    name("The Drawing of the Three")
  }

  book(sequence:3) 
  {
    name("Wastelands")
  }

  book(sequence:4) 
  {
    name("Wizard and Glass")
  }

  book(sequence:5) 
  {
    name("Wolves of the Calla")
  }

  book(sequence:6) 
  {
    name("Song of Susannah")
  }

  book(sequence:7) 
  {
    name("The Dark Tower")
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
