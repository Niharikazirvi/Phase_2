//adjacency list implementation
#include <iostream>
#include <list>

using namespace std;

class graph{
	private:
		int verts;
		list<int>* adjList;
	public:
		graph(int v){
			verts=v;
			adjList = new list<int>[v];// int type list of linked list created
		}
		void addEdge(int u, int v){
			adjList[u].push_back(v);}
		void display_graph(){// displaying the graph as list of linked lists
			for(int i=0;i<verts;i++){
			    std::cout<<i<<" ";
			    list<int>::iterator it = adjList[i].begin();
                while(it != adjList[i].end())
                	{std::cout<<(*it)<<"  ";
                		it++;}
            	std::cout<<std::endl;
			}
			std::cout<<endl;
		}
		~graph(){
			delete[] adjList;
		}

};

int main(){
	graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.display_graph();

    return 0;
}
