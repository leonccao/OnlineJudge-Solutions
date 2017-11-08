class Solution {
public:
    bool isMatch(string s, string p) {
        s = " " + s;
        
        // Transfer the p string into a more standard format
        string pt = " ";
        vector<bool> star;
        star.push_back(false);
        for (int i = 0; i < p.size(); i ++) {
            if (p[i] == '*') continue;
            pt.append(1, p[i]);
            // If it is x* format
            if (i < p.size() && p[i + 1] == '*')
                star.push_back(true);
            else star.push_back(false);
        }
        
        vector<bool> oddf, evenf;
        for (int i = 0; i < pt.size(); i ++) {
            oddf.push_back(false);
            evenf.push_back(false);
        }
        
        // Prepare for the first character
        evenf[0] = true;
        for (int j = 1; j < pt.size(); j ++) {
            if (star[j])
                if (evenf[j - 1]) evenf[j] = true;
        }
        
        for (int i = 1; i < s.size(); i ++) {
            if (i % 2) {
                for (int j = 1; j < pt.size(); j ++) {
					
                    if (!star[j] && evenf[j - 1]) {
                        if (pt[j] == '.' || s[i] == pt[j])
                            oddf[j] = true;
                        else oddf[j] = false;
                        
                    } else if (star[j]) {
                        if (oddf[j - 1]) oddf[j] = true;
                        else if (pt[j] == '.' || s[i] == pt[j]) {
                            if (evenf[j] || evenf[j - 1])
                                oddf[j] = true;
                            else oddf[j] = false;
                        } else oddf[j] = false;
                    } else oddf[j] = false;
                }
            } else {
                
                for (int j = 1; j < pt.size(); j ++) {
                    
                    if (!star[j] && oddf[j - 1]) {
                        if (pt[j] == '.' || s[i] == pt[j])
                            evenf[j] = true;
                        else evenf[j] = false;
                        
                    // If .* or x*
                    } else if (star[j]) {
                        if (evenf[j - 1]) evenf[j] = true;
                        else if (pt[j] == '.' || s[i] == pt[j]) {
                            if (oddf[j] || oddf[j - 1])
                                evenf[j] = true;
                            else evenf[j] = false;
                        } else evenf[j] = false;
                    } else evenf[j] = false;
                }
            }
            // Cancel the preparation for the first character
            evenf[0] = false;
        }
            
        if (s.size() % 2) {
            if (evenf[pt.size() - 1])
                return true;
            else return false;
        } else {
            if (oddf[pt.size() - 1])
                return true;
            else return false;
        }
    }
};