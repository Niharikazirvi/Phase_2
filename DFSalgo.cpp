
#include <iostream>
#include <list>
using namespace std;

class Graph
{
private:
    int Verts;
    list<int> *adjLists;
    bool *visited;

public:
    Graph(int vertices){
        Verts = vertices;
        adjLists = new list<int>[vertices];
        visited = new bool[vertices];
    }
    void addEdge(int u, int v){
        adjLists[u].push_front(v);
    }
    void DFS(int vertex){
        visited[vertex] = true;
        list<int> adjList = adjLists[vertex];
        cout<<vertex<<"";
        list<int>::iterator i;
        for(i = adjList.begin(); i != adjList.end(); ++i){
		    //cout<<vertex<<" ";
            if(!visited[*i])
                DFS(*i);
			}
		}
	~Graph(){ 
		
				delete[] visited;
			
				delete[] adjLists;
			}
	};

 int main()
       
{ Graph g(6);
    g.addEdge(0, 1);
    g.addEdge(0, 2);

    g.addEdge(1, 3);
    g.addEdge(1, 4);

    g.addEdge(2, 5);
    
    g.DFS(0);
    return 0;
	}
