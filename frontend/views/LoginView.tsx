import { login } from '@hilla/frontend';
import { LoginForm } from '@hilla/react-components/LoginForm.js';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
export function LoginView() {
  const navigateTo = useNavigate();
  const [hasError, setError] = useState<boolean>();
   return(
       <div className="flex items-center justify-center h-full">
           <LoginForm 
              noForgotPassword 
              title='TODO List' 
              error={hasError}
              onLogin={
              async ({ detail: { username, password } }) => {
                setError(false);
                const result = await login(username, password);
                //console.dir(JSON.stringify(result));
                if (result.error) {
                  setError(true);
                } else {
                  navigateTo('/');
                }
              }
           }/>           
       </div>
   )
}
