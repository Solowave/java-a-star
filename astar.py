import math

class Node:
    def __init__(self, x, y, parent, g, h):
        self.x = x
        self.y = y
        self.parent = parent
        # Distence from start_node
        self.g = g
        # Distence from end_node
        self.h = h
        # Cost
        self.f = g + h
    
    def __eq__(self, n):
        if(n.x == self.x and n.y == self.y):
            return True
        else:
            return False

def main():

    def getDistence(sx, sy, ex, ey):
        return round(math.sqrt( ((sx - ex) ** 2) + ((sy - ey) ** 2) ), 1)

    def reconstruct_path(start, current):
        moves = []
        while(start != current):
            moves.append(current)
            current = current.parent
        return moves

    area = [
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0]
    ]

    start_point = Node(0, 0, None, 0, getDistence(0,0,4,4))
    end_point = Node(4, 4, None, getDistence(0,0,4,4), 0)

    open_list = []
    closed_list = []

    open_list.append(start_point)

    current_node = start_point
    curNodeIndx = 0

    while(len(open_list) > 0):
        for index in range(0, len(open_list)):
            if(open_list[index].f < current_node.f):
                current_node = open_list[index]
                curNodeIndx = index

        print("\n Current Node: F,G,H: " + str(current_node.f) + " " + str(current_node.g) + " " + str(current_node.h) + " XY:" + str(current_node.x) + " " + str(current_node.y))
    
        if(end_point == current_node):
            return reconstruct_path(start_point, current_node)

        open_list.pop(curNodeIndx)

        possible_neighbors = [
            [-1,1],[0,1],[1,1],
            [-1,0],[1,0],
            [-1,-1],[0,-1],[-1,1]
        ]

        best_neighbor = None

        print("New Neighbor Set \n")

        for neighbor in possible_neighbors:
            # Current g cost = old g cost + distence from old g cost
            tentative_gscore = current_node.g + getDistence(
                current_node.x,
                current_node.y,
                current_node.x + neighbor[0],
                current_node.y + neighbor[1]
            )

            # fscore is the cost of movement - the distence from old point to new one
            tentative_fscore = getDistence(
                current_node.x + neighbor[0],
                current_node.y + neighbor[1],
                end_point.x,
                end_point.y
            )

            neighbor_node = Node(current_node.x + neighbor[0], current_node.y + neighbor[1], current_node, tentative_gscore, tentative_fscore)

            # print("Same type?: " + str(type(best_neighbor) == type(neighbor_node)))
            # print("Current BestNeighbor: " + Node)

            if(type(best_neighbor) == type(neighbor_node)):
                print(best_neighbor.f)
                if(neighbor_node.f < best_neighbor.f):
                    best_neighbor = neighbor_node
                    open_list.append(best_neighbor)
                    print("Adding " + str(best_neighbor.f) + " to the open_list")
            else: 
                best_neighbor = neighbor_node
    
    print(open_list)

    return False

print("start")

print(main())

print("emd")