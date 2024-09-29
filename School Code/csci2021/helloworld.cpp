#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
//     vector<string> msg {"Hello","World"};
//     for (const string& word:msg){
//         cout<<word<<" ";
// }
// cout<<endl;

int x = 7;
int *p = &x;
int *q = NULL;
int y = *p;

q = &y;
x = 10;
printf("%d\n", x);
}