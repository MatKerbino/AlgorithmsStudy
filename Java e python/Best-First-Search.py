import heapq

class Problem:
    def __init__(self, initialState, goal, graph, heuristics):
        self.initialState = initialState
        self.goal = goal
        self.graph = graph
        self.heuristics = heuristics

    def actions(self, state):
        return self.graph.get(state, {}).keys()

    def result(self, state, action):
        return action

    def action_cost(self, state, action, result):
        return self.graph[state][action]

    def is_goal(self, state):
        return state == self.goal

    def heuristic(self, state):
        return self.heuristics.get(state, float('inf'))

class Node:
    def __init__(self, state, parent=None, action=None, path_cost=0):
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = path_cost

    def __lt__(self, other):
        return self.path_cost < other.path_cost

def bestFirstSearch(problem, f):
    node = Node(problem.initialState)
    frontier = [(f(node), node)]
    reached = {problem.initialState: node}

    while frontier:
        _, node = heapq.heappop(frontier)

        if problem.is_goal(node.state):
            return node

        for child in expand(problem, node):
            s = child.state
            if s not in reached or child.path_cost < reached[s].path_cost:
                reached[s] = child
                heapq.heappush(frontier, (f(child), child))
    return None

def expand(problem, node):
    s = node.state
    for action in problem.actions(s):
        s_prime = problem.result(s, action)
        cost = node.path_cost + problem.action_cost(s, action, s_prime)
        yield Node(state=s_prime, parent=node, action=action, path_cost=cost)

def printSolution(node):
    path = []
    while node:
        path.append(node.state)
        node = node.parent
    path.reverse()
    print(" -> ".join(path))

# Grafo e heurísticas
graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'D': 3, 'E': 5},
    'C': {'F': 5},
    'D': {'G': 3},
    'E': {'G': 1},
    'F': {'G': 2},
    'G': {}
}

heuristics = {
    'A': 7, 'B': 6, 'C': 4,
    'D': 3, 'E': 2, 'F': 1, 'G': 0
}

problem = Problem('A', 'G', graph, heuristics)
solution = bestFirstSearch(problem, lambda n: n.path_cost + problem.heuristic(n.state))

printSolution(solution)
