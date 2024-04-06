import { Project } from '../project';
import { User } from '../user';

export interface ProjectGateway {
  createNewProject(project: Project): Promise<{ error?: any }>;
  editProject(project: Project): Promise<{ error?: any }>;
  getProjectsByUser(user: User): Promise<{
    data: number[];
  }>;
  getTaskByProject(project: Project): Promise<{ error?: any }>;
}
