
#include <iostream>
#include <list>
using namespace std;

class Graph
{  private:
    int Verts;
    list<int>* adjLists;
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
    void BFS(int startVertex){
        visited[startVertex] = true;
        list<int> queue;
	    //int t = adjLists[startVertex];
		//queue.push_back(t);
		queue.push_back(startVertex);
		//queue.push_back(StartVertex);
       // list adjList = adjLists[vertex];
       list<int>::iterator i;
        while(!queue.empty()){
        	int c = queue.front();
        	 cout << c << " "; // output the elt in BFS manner
			queue.pop_front(); 
			//cout<<"visited"<<vert <<" ";
        	//queue.pop_front();
        	for(i=adjLists[c].begin(); i!=adjLists[c].end(); i++){
        		if(!visited[*i]){
        		    queue.push_back(*i); //it wont go in recursion ..insted once entered 
        								//BFS(*i);// it will keep on add elts in queue and will come out of while loop only after traversing the whole list in BFS order
						}
			}
		}
    }
    	~graph(){ 
			for(int i=0;i<verts; verts++){
				delete[] visited;
				}
				delete[] adjLists;
			}
};
        
        /*for(i = adjList.begin(); i != adjList.end(); ++i)
            if(!visited[*i])
                DFS(*i);}};*/
int main()
{ Graph g(6);
    g.addEdge(0, 1);
    g.addEdge(0, 2);

    g.addEdge(1, 3);
    g.addEdge(1, 4);

    g.addEdge(2, 5);
    
    g.BFS(0);
    return 0;
    
}
