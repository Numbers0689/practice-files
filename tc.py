def parse_input(n, cards):
    card_set = set()
    for card in cards:
        x, y, z, axis = card.split()
        card_set.add((int(x), int(y), int(z), axis))
    return card_set

def find_boundaries(cards):
    min_x, min_y, min_z = float('inf'), float('inf'), float('inf')
    max_x, max_y, max_z = float('-inf'), float('-inf'), float('-inf')
    
    for x, y, z, axis in cards:
        min_x = min(min_x, x)
        min_y = min(min_y, y)
        min_z = min(min_z, z)
        max_x = max(max_x, x)
        max_y = max(max_y, y)
        max_z = max(max_z, z)
    
    return min_x, max_x, min_y, max_y, min_z, max_z

def is_closed_box(cards, boundaries):
    min_x, max_x, min_y, max_y, min_z, max_z = boundaries
    missing_card = None
    
    # Check each face of the bounding box
    faces = [
        (min_x, max_x, min_y, max_y, min_z, 'xy'),
        (min_x, max_x, min_y, max_y, max_z, 'xy'),
        (min_x, max_x, min_z, max_z, min_y, 'xz'),
        (min_x, max_x, min_z, max_z, max_y, 'xz'),
        (min_y, max_y, min_z, max_z, min_x, 'yz'),
        (min_y, max_y, min_z, max_z, max_x, 'yz'),
    ]
    
    for x1, x2, y1, y2, fixed, axis in faces:
        for i in range(x1, x2):
            for j in range(y1, y2):
                if axis == 'xy' and (i, j, fixed, axis) not in cards:
                    return False, (i, j, fixed, axis)
                elif axis == 'xz' and (i, fixed, j, axis) not in cards:
                    return False, (i, fixed, j, axis)
                elif axis == 'yz' and (fixed, i, j, axis) not in cards:
                    return False, (fixed, i, j, axis)
    
    return True, None

def compute_volume(boundaries):
    min_x, max_x, min_y, max_y, min_z, max_z = boundaries
    return (max_x - min_x) * (max_y - min_y) * (max_z - min_z)

def main():
    n = int(input())  # Number of cards
    cards = [input().strip() for _ in range(n)]
    
    card_set = parse_input(n, cards)
    boundaries = find_boundaries(card_set)
    closed, missing = is_closed_box(card_set, boundaries)
    
    if closed:
        print(compute_volume(boundaries))
    else:
        x, y, z, axis = missing
        print(x, y, z, axis)

main()
# Example Input
# 7
# 0 0 0 xy
# 0 0 0 yz
# 1 0 0 yz
# 0 1 0 yz
# 0 0 1 xy
# 1 1 0 xz
# 1 0 1 xz
# 9
# 0 0 0 xy
# 0 0 0 yz
# 0 0 0 xz
# 0 0 1 xy
# 0 1 0 xz
# 1 0 0 xy
# 1 0 0 xz
# 2 0 0 yz
# 1 1 0 xz

# 10
# 0 0 0 xy
# 0 0 0 yz
# 0 0 0 xz
# 0 0 1 xy
# 0 1 0 xz
# 1 0 0 xy
# 1 0 0 xz
# 1 0 1 xy
# 2 0 0 yz
# 1 1 0 xz