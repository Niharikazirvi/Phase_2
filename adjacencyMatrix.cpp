 #include <iostream>


using namespace std;

#include <iostream>
#include <conio.h>
using namespace std;

class graph{
private:
      int** adjMat;
      int verts;
      //int a[verts][verts];// thats a static 2D array

public:
      graph(int n) { //constructor
            verts=n;

			//a[verts][verts];// now again this can't be used

			adjMat = new int*[verts]; // == int** adjMat= new int*[verts];

            for (int i = 0; i < verts; i++) {
            		adjMat[i]=new int[verts];


                  for (int j = 0; j < verts; j++){
                  	 //a[i][j] = 0; // again its static allocation;
                  	 adjMat[i][j]= 0;
                    }
         	}
         }


			void add_edge(int i,int j){
				adjMat[i][j]=1;
				adjMat[j][i]=1;
			}

			void remove_edge(int i, int j){
				adjMat[i][j]=0;
				adjMat[j][i]=0;

			}

			void display_ajdMat(){
				std::cout<<endl;
				for(int i=0;i<verts;i++){
					for(int j=0;j<verts;j++){
						std::cout<<adjMat[i][j]<<" ";
					}
					std::cout<<endl;
				}

			}
			~graph(){ // destructor
				for(int i=0;i<verts; i++){
					delete[] adjMat[i];
				}
				//delete[] adjMat;
			}


};

int main(){
	int n;
	std::cout<<"enter the no. of edges of graph"<<"/n";
	std::cin>>n;
	graph graph1(n);
	graph1.display_ajdMat();

	graph g2(6);
	g2.add_edge(3,2);
	g2.add_edge(5,1);
	g2.add_edge(4,2);
	g2.add_edge(1,2);
	g2.display_ajdMat();



	return 0;

}



/*class graph{

		private:
			int verts;
			int a[verts][verts];



		public:

			graph(int verts){
				this->verts = verts;
				this->a[verts][verts] = a[verts][verts];
				for(int i=0;i<verts;i++){
						for(int j=0;j<verts;j++){
							a[i][j]=0;
						}
				}
			}

			void add_edge(int i,int j){
				a[i][j]=1;
				a[j][i]=1;
			}

			void remove_edge(int i, int j){
				a[i][j]=0;
				a[j][i]=0;

			}

			void display_ajdMat(){
				for(int i=0;i<verts;i++){
					for(int j=0;j<verts;j++){
						std::cout<<a[i][j]<<" ";
					}
					std::cout<<'/n';
				}

		}


};
*/



