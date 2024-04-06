'use client';
import Card from '@/components/card/card';
import { FlexColumContainer } from '@/components/container/container';
import Input from '@/components/input/input';
import Navbar from '@/components/navbar/navbar';
import { Title } from '@/components/text/text';
import { ProjectGateway } from '@/lib/domain/model/gateways/projectGatewat';
import { User } from '@/lib/domain/model/user';
import { GetProjectsUseCase } from '@/lib/domain/useCase/projectUseCase';
import ProjectRepository from '@/lib/infrastructure/driver_adapters/repositories/projectRepository';
import Link from 'next/link';
import * as React from 'react';
import { useQuery } from 'react-query';
import styles from './proyectos.module.css';
interface IProyectosProps {}

const projectGateway: ProjectGateway = new ProjectRepository();
const projectsByUser = new GetProjectsUseCase(projectGateway);

const Proyectos: React.FunctionComponent<IProyectosProps> = (props) => {
  const listProjects = () => {
    return cards.map((el) => {
      return (
        <Link key={el.title} href={'/home/projects/project'}>
          <Card key={el.title} card={el} />
        </Link>
      );
    });
  };
  const cards = [
    {
      title: 'Projecto 1',
      description: 'Project 1',
    },
    {
      title: 'Projecto 2',
      description: 'Project 2',
    },
    {
      title: 'Projecto 3',
      description: 'Project 3',
    },
    {
      title: 'Projecto 4',
      description: 'Project 4',
    },
    {
      title: 'Projecto 5',
      description: 'Project 5',
    },
    {
      title: 'Projecto 6',
      description: 'Project 6',
    },
  ];

  return (
    <div className={styles.projects_container}>
      <Navbar />
      <main className={styles.projects_content}>
        <FlexColumContainer>
          <Title>Mis proyectos</Title>
          <Input
            placeholder="Ingresa el titulo o descrición del proyecto que buscas"
            type="text"
          />
          <div className={styles.projects}>{listProjects()}</div>
        </FlexColumContainer>
      </main>
    </div>
  );
};

export default Proyectos;
