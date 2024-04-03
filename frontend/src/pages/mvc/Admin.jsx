import CrudTable from './CrudTable'

import { useAuth } from "../../components/auth/AuthContext";

export default function Admin() {

  const { isLoggedIn } = useAuth();

  return (
    <div className='min-h-[90.8vh] p-[6.9vh]'>
      {isLoggedIn && 
      <CrudTable/>
      }
      {!isLoggedIn && 
      <h1 className="text-center text-large">No tienes permisos para ver esta página</h1>
      }
    </div>
  );
}
