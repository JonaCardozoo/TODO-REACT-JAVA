import HelloWorldView from 'Frontend/views/helloworld/HelloWorldView.js';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, RouteObject } from 'react-router-dom';

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));
import TodoView from './views/TodoView';
import { LoginView } from './views/LoginView';

const routing = [
  {path:'/login', element: <LoginView/>},
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/', element: <HelloWorldView />, handle: { title: 'Hello World' } },
      { path: '/about', element: <AboutView />, handle: { title: 'About' } },
      { path: '/todo', element: <TodoView />, handle: { title: 'Todo' } },
    ],
  },
] as RouteObject[];

export const routes = routing;
export default createBrowserRouter(routes);

