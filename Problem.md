## OOP Example 
## Problem Description
```text 
Every night the below bands play. Also, Steve Nick’ who plays a six-stringed bass, with string-size .7 mm,
made by Fodera is eager to join any band that would allow him since his previous band was dissolved.
More bands will join soon.
```
#### Band: ”Run away Slide”
```json
{
   "name": "Tony Gose",
   "instrument": {
      "name": "Banjo",
      "numberOfStrings": 6,
      "numberOfKeys": 0,
      "manufacturer": "Fender",
      "size": "0.9mm"
   }
}
```

```json
{
   "name": "Mr Mee",
   "instrument": {
      "name": "Piano",
      "numberOfStrings": 0,
      "numberOfKeys": 64,
      "manufacturer": "Honda",
      "is": "acoustic"
   }
}
```

```json
{
   "name": "Crazy Joe",
   "instrument": {
      "name": "Drums",
      "numberOfStrings": 0,
      "numberOfKeys": 0,
      "has": "hi-hat",
      "manufacturer": "Killy"
   }
}
```
#### Band: ”Axelhoff”
```json
{
   "name": "Tiny Tina",
   "instrument": {
      "name": "Bass",
      "numberOfStrings": 5,
      "numberOfKeys": 0,
      "manufacturer": "Gibson",
      "size": "4mm"
   }
}
```

```json
{
   "name": "Danei",
   "instrument": {
      "name": "Drums",
      "numberOfStrings": 0,
      "numberOfKeys": 0,
      "has": "Regnal",
      "manufacturer": "Gibson"
   }
}
```

```json
{
   "name": "Sven",
   "instrument": {
      "name": "Synthesizer",
      "numberOfStrings": 0,
      "numberOfKeys": 64,
      "has": "no LED",
      "manufacturer": "Suzuki"
   }
}
```

<b> Bands can have any number of members as long as there are not more than one of each instrument
present. Every day each band loses a random member, if there are any. Bandless musicians try joining
a random band. </b>

#### Tasks
1. <b> List </b> List all bands by name with their members and the properties of their instruments.
2. <b>Play one night </b> - Execute logic for each band to lose a random member and musicians without a
   band to try joining a random band. Print all changes to the console.
   <i> For example ”Musician Tiny
   Tina left Axelhoff. Musician Mer Mee left Run away Slide. Musician Steve Nick’ joined Run away
   Slide.” </i>
3. <b> Play ten nights </b> - Execute the same logic for 10 nights in a row and print all the changes to the
   console.