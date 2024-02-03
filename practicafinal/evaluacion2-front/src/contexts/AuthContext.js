import { createContext, useState, useContext, useEffect } from 'react';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState("");
  
    useEffect(()=>{
        if(user===""){
            let userData=localStorage.getItem('user');
            if (userData) {
                setUser(userData);
            }
        } 
    },[])

    const loginUser = (user, token) => {
        localStorage.setItem("token", token);
        localStorage.setItem("user", user);
        setUser(localStorage.getItem("user"));
    }

    const logoutUser = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        setUser("");
    };

  return (
    <AuthContext.Provider value={{ user, loginUser, logoutUser }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  return useContext(AuthContext);
};