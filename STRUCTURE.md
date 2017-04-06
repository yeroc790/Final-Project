<h1>Class Structures</h1>

<h2>Map</h2>
<p>The map is basically the "world", it keeps track of what is where
<p><strong>Instance Variables:</strong><br>
  A multidimensional array of type BoardObject
</p>
<p><strong>Methods:</strong><br>
  Various positioning and movement related things<br>
  displayMap() which displays the current map on the console<br>
  Basic accessors and mutators<br>
  A method that reads in from a text file and sets up a map
</p>

<h2>BoardObject</h2>
<p>Board Object is the parent class for things displayed on the board</p>
<p><strong>Instance Variables:</strong><br>
  Index Coordinates for where it is on the board, probably<br>
  A string (or char) containing what it displays for the displayMap() method
</p>
<p><strong>Mehods:</strong><br>
  Basic accessors and mutators
</p>

<h2>Item</h2>
<p>Item extends BoardObject, and is the parent class for all the in-game items the user can find</p>
<p><strong>Instance Variables:</strong><br>
  Name of the item<br>
  Somehow store it's stats, probably a string to be parsed later<br>
  A boolean that checks if the player has equipped it, maybe
</p>
<p><strong>Methods:</strong><br>
<p>
  Not sure yet
</p>

<h2>Weapon</h2>
<p>Extends Item, affects players attack, not sure how I want to set that up</p>

<h2>Armor</h2>
<p>Extends Item, affects players defence, not sure how I want to set that up</p>

<h2>Chest</h2>
<p>Extends BoardObject, contents are decided when the chest is opened</p>
<p><strong>Instance Variables:</strong><br>
  An array of type Item<br>
  A boolean that determines if it has been opened or not, maybe
</p>
<p><strong>Methods:</strong><br>
  openChest() - this triggers an RNG thing that populates the array of items
</p>

<h2>Menu</h2>
<p>The main navigation, there will be child classes for each different menu that is needed in the game</p>
<p>There needs to be an inventory menu</p>

<h2>Character</h2>
<p>Extends BoardObject</p>
<p><strong>Instance Variables:</strong><br>
  Health - the players health, 20/20<br>
  Attack - an integer that tracks the attack level of the player, boosted by weapons<br>
  Defense - could either be a percentage that changes how much damage you take, or it just affects your max health<br>
</p>

<h2>Player</h2>
<p>Extends Character</p>
<p><strong>Instance Variables:</strong><br>
  Inventory - probably an array of type Item, probably of infinite size, or a large enough size that inventory management isn't necessary<br>
</p>

<h2>Enemy</h2>
<p>Extends Character, base class for all monsters</p>
<p>There needs to be a tier system, so that in the game setup text file, you can type a number 1-5, and it will spawn a random enemy from that tier</p>
<p><strong>Instance Variables:</strong><br>
  Name<br>
</p>
<p><strong>Methods:</strong><br>
  Not sure<br>
</p>

<hr>

<h2>Game resource file</h2>
<p>This is stored as a text file that contains symbols, which the loadGame() method in class Map uses to populate the map</p>
<p><strong>Symbols:</strong><p>
<ul>
<li>" " - empty space</li>
<li>"|" - a wall</li>
<li>"P" - the player</li>
<li>"1" - Tier 1 enemy</li>
<li>"2" - Tier 2 enemy</li>
<li>"3" - Tier 3 enemy</li>
<li>"4" - Tier 4 enemy</li>
<li>"5" - Tier 5 enemy</li>
<li>"C" - Chest</li>
<li>"D" - Door</li>
