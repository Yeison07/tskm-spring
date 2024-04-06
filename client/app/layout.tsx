import '@fontsource/roboto';
import '@fontsource/roboto/500.css';
import 'normalize.css';
import '../styles/globals.css';
import { ReactQueryProvider } from './reactQueryProvider';

export const metadata = {
  title: 'TaskMe!',
  description: 'Sitio web para la gestion de proyectos, tareas y demas',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <ReactQueryProvider>
      <html lang="es">
        <body>{children}</body>
      </html>
    </ReactQueryProvider>
  );
}
