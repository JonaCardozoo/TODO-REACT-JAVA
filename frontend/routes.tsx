import HelloWorldView from 'Frontend/views/helloworld/HelloWorldView.js';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import TodoView from './views/TodoView';

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));

const routing = [
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/todo', element: <TodoView />, handle: { title: 'Todo' } },
      { path: '/', element: <HelloWorldView />, handle: { title: 'Hello World' } },
      { path: '/about', element: <AboutView />, handle: { title: 'About' } },
    ],
  },
] as RouteObject[];

export const routes = routing;
export default createBrowserRouter(routes);
