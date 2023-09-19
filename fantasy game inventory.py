
trash = {'rope': 1, 'torch': 6, 'gold coin': 42, 'dagger': 1, 'arrow': 12}


def display_inventory(inventory):
    print("Inventory: ")
    total = 0
    for keys in inventory.keys():
        print(str(inventory[keys]) + " " + keys)
        total += inventory[keys]
    print("")
    print("Total stuffs in the bag: " + str(total))


inv = {'gold coin': 42, 'rope': 1}
dragonLoot = ['gold coin', 'dagger', 'gold coin', 'gold coin', 'ruby']


def add_to_inventory(inventory, add_items):
    for item in add_items:
        if item in inventory:
            inventory[item] += 1
        else:
            inventory[item] = 1


add_to_inventory(inv, dragonLoot)
display_inventory(inv)
