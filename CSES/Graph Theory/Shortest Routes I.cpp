#include<iostream>
#include<vector>
#include<queue>
#include<climits>
#define ll long long int
using namespace std;

void solve() {
	int N, M;
	cin >> N >> M;
	vector<vector<pair<ll, ll>>> graph(N+1);
	for (int i=1; i<=M; i++) {
		int src;
		ll dest, time;
		cin >> src >> dest >> time;
		
		graph[src].push_back(make_pair(dest, time));
	}
	
	vector<ll> time(N+1, LLONG_MAX);
	priority_queue<pair<ll, ll>,vector<pair<ll, ll>>,greater<pair<ll, ll>>> pqueue;
	
	pqueue.push({0, 1});
	time[1]=0;
	
	while (pqueue.size()>0) {
		auto curr=pqueue.top();
		pqueue.pop();
		
		ll currTime=curr.first;
		int city=(int)(curr.second);
		
		if (time[city]<currTime) continue;
		
		for (auto node : graph[city]) {
			int dest=node.first;
			ll tempTime=node.second;
			ll newTime=time[city]+tempTime;
			
			if (newTime<time[dest]) {
				pqueue.push({newTime, dest});
				time[dest]=newTime;
			}
		}
	}
	
	for (int i=1; i<=N; i++) {
		cout << time[i] << " ";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int tc=1;
	//cin >> tc;
	while (tc--) solve();
}