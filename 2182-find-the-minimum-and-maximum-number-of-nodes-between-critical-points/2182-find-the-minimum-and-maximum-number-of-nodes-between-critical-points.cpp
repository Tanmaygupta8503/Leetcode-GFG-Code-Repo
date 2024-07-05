class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int>temp;
        int firstCP = 0 , second_LastCP = 0 , lastCP = 0;
        ListNode* prev = head;
        ListNode* curr = head->next;
        int cnt = 1;
        while(curr->next != NULL && curr != NULL){
            if(curr->val > prev->val && curr->val > curr->next->val){   // local maxima.
               temp.push_back(cnt);
            }
            else if(curr->val < prev->val && curr->val < curr->next->val){  // local minima.
               temp.push_back(cnt);
            }
            cnt ++;
            prev = curr;
            curr = curr->next;
        }
        if(temp.size() < 2)return {-1 , -1};
        else if(temp.size() == 2) return{temp[1] - temp[0] , temp[1] - temp[0]};
        int n = temp.size();
        int minDistance = INT_MAX;
        int maxDistance = temp[n - 1] - temp[0];
        for(int i = 1 ; i < n ; i ++){
            minDistance = min(minDistance , temp[i] - temp[i - 1]);
        }
        return {minDistance , maxDistance};
    }
};