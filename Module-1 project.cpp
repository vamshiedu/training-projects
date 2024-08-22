#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <bits/stdc++.h>
using namespace std;

bool sortByValue(const pair<int, int> &a, const pair<int, int> &b) {
    return a.second < b.second;  
}

int main() {
    int n;
    cin>>n;
    map<int, int> userAccount;
    while(n--){
            int userId;
            int balance;
            cin>>userId>>balance;
            userAccount[userId] = balance;
    }
    int t;
    cin>>t;
    while(t--){
        int from_userId;
        int to_userId;
        int amount;
        cin>>from_userId>>to_userId>>amount;
        if(userAccount[from_userId] < amount){
            cout<<"Failure"<<endl;
        }
        else{
            userAccount[from_userId]-=amount;
            userAccount[to_userId]+=amount;
            cout<<"Success"<<endl;
        }
    }
    cout<<endl;
    
    vector<pair<int, int>> sortedAccounts(userAccount.begin(), userAccount.end());
    sort(sortedAccounts.begin(), sortedAccounts.end(), sortByValue);
    for (auto &entry : sortedAccounts) {
        cout << entry.first << " " << entry.second << endl;
    }
    return 0;
}
