import sys

class Stack (object):
  def __init__ (self):
    self.stack = []

  # add an item to the top of the stack
  def push (self, item):
    self.stack.append ( item )

  # remove an item from the top of the stack
  def pop (self):
    return self.stack.pop()

  # check what item is on top of the stack without removing it
  def peek (self):
    return self.stack[len(self.stack) - 1]

  # check if a stack is empty
  def isEmpty (self):
    return (len(self.stack) == 0)

  # return the number of elements in the stack
  def size (self):
    return (len(self.stack))

  def __str__(self):
    return str(self.stack)

class Queue (object):
  def __init__ (self):
    self.queue = []

  def enqueue (self, item):
    self.queue.append (item)

  def dequeue (self):
    return (self.queue.pop(0))

  def isEmpty (self):
    return (len (self.queue) == 0)

  def size (self):
    return len (self.queue)

class Vertex (object):
  def __init__ (self, label):
    self.label = label
    self.visited = False

  # determine if vertex was visited
  def wasVisited (self):
    return self.visited 

  # determine the label of the vertex
  def getLabel (self):
    return self.label

  # string representation of the label
  def __str__(self):
    return str (self.label)


class Edge (object):
  def __init__ (self, fromVertex, toVertex, weight):
    self.u = fromVertex
    self.v = toVertex
    self.weight = weight

  def __str__(self):
    return str(self.u) + " - " + str(self.v)

  # comparison operators
  def __lt__ (self, other):
    return self.weight < other.weight
  def __le__ (self, other):
    return self.weight <= other.weight
  def __gt__ (self, other):
    return self.weigt > other.weight
  def __ge__ (self, other):
    return self.weight >= other.weight
  def __eq__ (self, other):
    return self.weight == other.weight
  def __ne__ (self, other):
    return self.weight != other.weight
  
class Graph (object):
  def __init__ (self):
    self.Vertices = []
    self.adjMat = []
    self.edges = []

  # checks if a vertex label already exists
  def hasVertex (self, label):
    nVert = len (self.Vertices)
    for i in range (nVert):
      if (label == (self.Vertices[i]).label):
        return True
    return False

  # add a vertex with given label
  def addVertex (self, label):
    if not self.hasVertex (label):
      self.Vertices.append (Vertex (label))

      # add a new column in the adjacency matrix for new Vertex
      nVert = len (self.Vertices)
      for i in range (nVert - 1):
        (self.adjMat[i]).append (0)
    
      # add a new row for the new Vertex in the adjacency matrix
      newRow = []
      for i in range (nVert):
        newRow.append (0)
      self.adjMat.append (newRow)

  # add weighted directed edge to graph
  def addDirectedEdge (self, start, finish, weight = 1):
    self.adjMat[start][finish] = weight
    edge = Edge(start, finish, weight)
    self.edges.append(edge)

  # add weighted undirected edge to graph
  def addUndirectedEdge (self, start, finish, weight = 1):
    self.adjMat[start][finish] = weight
    self.adjMat[finish][start] = weight

  # return an unvisited vertex adjacent to v
  def getAdjUnvisitedVertex (self, v):
    nVert = len (self.Vertices)
    for i in range (nVert):
      if (self.adjMat[v][i] > 0) and (not (self.Vertices[i]).wasVisited()):
        return i
    return -1

  # does a depth first search in a graph
  def dfs (self, v):
    # create a stack
    theStack = Stack()

    # mark the vertex as visited and push on the stack
    (self.Vertices[v]).visited = True
    print (self.Vertices[v])
    theStack.push (v)

    while (not theStack.isEmpty()):
      # get an adjacent unvisited vertex
      u = self.getAdjUnvisitedVertex (theStack.peek())
      if (u == -1):
        u = theStack.pop() 
      else:
        (self.Vertices[u]).visited = True
        print (self.Vertices[u])
        theStack.push(u)

    # stack is empty reset the flags
    nVert = len (self.Vertices)
    for i in range (nVert):
      (self.Vertices[i]).visited = False


  # does a breadth first search in a graph
  def bfs (self, v):
    # create a queue
    theQueue = Queue ()

    # mark the vertex as visited and enqueue
    (self.Vertices[v]).visited = True
    print (self.Vertices[v])
    theQueue.enqueue (v)

    while (not theQueue.isEmpty()):
      # get the vertex at the front
      v1 = theQueue.dequeue()
      # get an adjacent unvisited vertex
      v2 = self.getAdjUnvisitedVertex (v1)
      while (v2 != -1):
        (self.Vertices[v2]).visited = True
        print (self.Vertices[v2])
        theQueue.enqueue (v2)
        v2 = self.getAdjUnvisitedVertex (v1)

    # queue is empty reset the flags
    nVert = len (self.Vertices)
    for i in range (nVert):
      (self.Vertices[i]).visited = False

  #gets index of vertex with that label
  def getIndex(self, label):
    indx = 0
    for vertex in self.Vertices:
      if vertex.label == label:
        return indx
      indx+=1

    return -1

  #get edge weight between two vertices
  #return -1 if edge does not exist
  def getEdgeWeight(self, fromVertexLabel, toVertexLabel):
    start = self.getIndex(fromVertexLabel)
    end = self.getIndex(toVertexLabel)

    #check if both vertices exist
    if start == -1 or end == -1:
      return -1
    weight = self.adjMat[start][end]
    #if weight does not exist return -1
    if weight == 0:
      return -1
    else:
      return weight

  # get a list of neighbors that you can go to from a vertex
  # return empty list if there are none
  def getNeighbors (self, vertexLabel):
    neighbors = []

    v = self.getIndex(vertexLabel)
    nVert = len (self.Vertices)
    for i in range (nVert):
      if (self.adjMat[v][i] > 0):
        neighbors.append(self.Vertices[i].label)
    return neighbors


  def getAdjVertices(self, vertex):
    neighbors = []

    v = self.Vertices.index(vertex)
    nVert = len (self.Vertices)
    for i in range (nVert):
      if (self.adjMat[v][i] > 0):
        neighbors.append(self.Vertices[i])
    return neighbors

  #return a copy of Vertices 
  def getVertices (self):
    return self.Vertices

  def check(self, v, parent):
    nVert = len (self.Vertices)
    for i in range (nVert):
      if (self.adjMat[v][i] > 0) and ((self.Vertices[i]).wasVisited()) and (i != parent) and (i != v):
        #print(i, self.Vertices[i].wasVisited() , v)
        return True
    return False
  #returns parent
  def getParent(self, child, theStack):
    try:
      return theStack.peek()
    except:
      return -1 

  # DONT NEED THIS METHOD ANYMORE
  def firstNode(self):
    for i in range(len(self.Vertices)):
      for v in range(len(self.Vertices)):
        if self.adjMat[v][i] != 0:
          break
        if v == len(self.Vertices) - 1:
          return i
    return -1

  #CHECKS IF YOU CANT GO ANYWHERE FROM THE VERTEX
  def noFrom(self, v):
    for i in range(len(self.Vertices)):
      if self.adjMat[v][i] != 0:
        return False
    return True

  def hasCycle(self):
    #start = self.firstNode()
    
    for v in range(len(self.Vertices)):
      theStack = Stack()
      childs = []
      count = 1
      # mark the vertex as visited and push on the stack
      (self.Vertices[v]).visited = True
      #print (self.Vertices[v])
      theStack.push (v)

      while (not theStack.isEmpty()):
        # get an adjacent unvisited vertex
        #print(theStack)
        child = theStack.peek()
        temp = theStack.pop()
        parent = self.getParent(child, theStack)
        theStack.push(temp)


        
        #parent = theStack.pop()
        if child not in childs:
          if self.noFrom(child):
            break
          cyclical = self.check(child, parent)
          #print("Parent: " + str(parent) + " Child: " + str(child))
          childs.append(child)
        
        u = self.getAdjUnvisitedVertex (theStack.peek())
        if cyclical == True:
            return True
        if (u == -1):
          u = theStack.pop()
          count += 1 
        else:
          (self.Vertices[u]).visited = True
          #print (self.Vertices[u])
          theStack.push(u)
          count += 1

      # stack is empty reset the flags
      nVert = len (self.Vertices)
      for i in range (nVert):
        (self.Vertices[i]).visited = False

    return False

  #prints lists of edges in ascending order of weight
  def edgeList (self):
  
    for i in range (len(self.edges) - 1):
    # find the minimum
      min = self.edges[i]
      minIdx = i

      for j in range (i + 1, len(self.edges)):
        if (self.edges[j].weight < min.weight):
          min = self.edges[j]
          minIdx = j

      # Swap the minimum element with the element at the ith place
      self.edges[minIdx] = self.edges[i]
      self.edges[i] = min
    
    for edge in self.edges:
      print(self.Vertices[edge.u].label + "--" + self.Vertices[edge.v].label + ' ' + str(edge.weight))
      # if i != len(self.edges) - 1:
      #   print(", "),
      # i += 1
    #print('')

  #returns a list of vertices after topo sort
  def toposort(self):
    if self.hasCycle():
      print("Has Cycle, Topo Sort could not be completed")
      return None
    stack = []
    for vertex in self.Vertices:
      if vertex.visited == False:
        self.search(vertex, stack)
    
    
    return stack

  def search(self, v, stack):
    v.visited = True
    for vertex in self.getAdjVertices(v):
      if vertex.visited == False:
        self.search(vertex, stack)
    stack.append(v)


  def deleteEdge (self, fromVertexLabel, toVertexLabel):
    start = self.getIndex(fromVertexLabel)
    end = self.getIndex(toVertexLabel)
    self.adjMat[start][end] = 0
    for edge in self.edges:
      if edge.u == start and edge.v == end:
        edgesToRemove = edge
        break

    self.edges.remove(edge)

  # delete a vertex from the vertex list and all edges from and
  # to it in the adjacency matrix
  def deleteVertex (self, vertexLabel):
    v = self.getIndex(vertexLabel)

    nVert = len (self.Vertices)
    #delete all edges to v
    for i in range (nVert):
      self.adjMat[i][v] = 0
    
    #delete all edges from v
    for i in range(nVert):
      self.adjMat[v][i] = 0

    edgesToRemove = []
    for edge in self.edges:
      print("U: " + str(edge.u) + " v: " +str(edge.v) + " Vertex: " + str(v))
      if edge.u == v or edge.v == v:
        edgesToRemove.append(edge)

    for edge in edgesToRemove:
      self.edges.remove(edge)

    for edge in self.edges:
      print(edge),
      print(", "),
    print('')


    self.Vertices.pop(v)

def main():
  n = int(input())
  emps = []
  for i in range(n):
    emps.append(Vertex(int(input())))
  
  

main()
  