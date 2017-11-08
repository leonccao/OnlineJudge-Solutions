class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int result;
        if ((nums1.size() + nums2.size()) % 2) {
            if (nums1.empty()) return nums2[nums2.size() / 2];
            if (nums2.empty()) return nums1[nums1.size() / 2];
            result = findMedian(nums1, nums2);
            if (result < 0)
                result = findMedian(nums2, nums1);
            return result;
        } else {
            if (nums1.empty()) return (nums2[nums2.size() / 2] + nums2[nums2.size() / 2 - 1]) / 2.0;
            if (nums2.empty()) return (nums1[nums1.size() / 2] + nums1[nums1.size() / 2 - 1]) / 2.0;
            int leftOne, rightOne, tmp;
                tmp = nums1.back();
                nums1.pop_back();
                leftOne = findMedian(nums1, nums2);
                if (leftOne < 0) leftOne = findMedian(nums2, nums1);
                nums1.push_back(tmp);
                nums1.push_back(tmp);
                rightOne = findMedian(nums1, nums2);
                if (rightOne < 0) rightOne = findMedian(nums2, nums1);
            return (leftOne + rightOne) / 2.0;
        }
    }
    
    int findMedian(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.empty()) return nums2[nums2.size() / 2];
        if (nums2.empty()) return nums1[nums1.size() / 2];
        int left = 0, right = nums1.size();
        int leftNum, rightNum, mid;
        while (left < right - 1) {
            mid = (left + right) / 2;
            leftNum = findLeft(nums2, nums1[mid]);
            rightNum = findRight(nums2, nums1[mid]);
            if ((leftNum  + mid <= (nums1.size() + nums2.size()) / 2)
             && (rightNum + mid >= (nums1.size() + nums2.size()) / 2))
                return nums1[mid];
            if (leftNum + mid > (nums1.size() + nums2.size()) / 2)
                right = mid;
            if (rightNum + mid < (nums1.size() + nums2.size()) / 2)
                left = mid + 1;
        } 
        if (left >= right) return -1;
        leftNum = findLeft(nums2, nums1[left]);
        rightNum = findRight(nums2, nums1[left]);
        if ((leftNum  + left <= (nums1.size() + nums2.size()) / 2)
             && (rightNum + left >= (nums1.size() + nums2.size()) / 2))
        return nums1[left];
        else return -1;
    }
    
    int findLeft(vector<int>& nums2, int target) {
        int left = 0, right = nums2.size();
        int mid;
        while (left < right - 1) {
            mid = (left + right) / 2;
            if (nums2[mid] == target) {
                if (right == mid + 1) {
                    if (nums2[mid] == nums2[mid - 1])
                        right = mid;
                    else left = mid;
                } else right = mid + 1;
            }
            if (nums2[mid] > target)
                right = mid;
            if (nums2[mid] < target)
                left = mid + 1;
        }
        if (left >= right) return right;
        if (nums2[left] < target) left ++;
        return left;
    }
    
    int findRight(vector<int>& nums2, int target) {
        int left = 0, right = nums2.size();
        int mid;
        while (left < right - 1) {
            mid = (left + right) / 2;
            if (nums2[mid] == target)
                left = mid;
            if (nums2[mid] > target)
                right = mid;
            if (nums2[mid] < target)
                left = mid + 1;
        }
        if (left >= right) return right;
        if (nums2[left] <= target) left ++;
        return left;
    }
};